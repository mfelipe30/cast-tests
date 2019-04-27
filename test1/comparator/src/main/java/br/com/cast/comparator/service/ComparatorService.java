package br.com.cast.comparator.service;

import java.util.Arrays;
import java.util.Optional;

import javax.xml.bind.ValidationException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.comparator.domain.Document;
import br.com.cast.comparator.repository.*;

@Service
public class ComparatorService {

	@Autowired
	public DocumentRepository repository;

	public Document salvar(Long id, String dados, String side) throws Exception {
		Document document = null;
		
		if(validador(id, dados)){
			document = repository.findById(id);
			
			if (document == null) {
				document = new Document();
				document.setId(id);
			}
	
			if(side.equals("LEFT")) {
				document.setLeft(dados);
			} else {
				document.setRight(dados);
			}
			
			document = repository.save(document);
		}
		
		return document;
	}
	
	public boolean validador(Long id, String data) throws ValidationException {
		boolean isValid = true;

		if (StringUtils.isEmpty(data)) {
			isValid = false;
		}
		
		return isValid;
	}
	
	public String validatorBase64(Long id) {
		Optional<Document> document = repository.findById(id);
		if (document == null) {
			return "Data not found!";
		}

		if (!StringUtils.isNotBlank(document.getLeft()) 
				|| !StringUtils.isNotBlank(document.getRight())) {
			return "Dados Base64 faltando.";
		}
		
		byte[] bytesLeft = document.getLeft().getBytes();
		byte[] bytesRight = document.getRight().getBytes();

		boolean resultado = Arrays.equals(bytesLeft, bytesRight);

		String offsets = "";

		if ( bytesLeft.length != bytesRight.length ) {
			return "Base64 data does not have the same size.";
		} else if ( resultado ) {
			return "Base64 data is the same";
		} else {
			byte different = 0;
			for (int index = 0; index < bytesLeft.length; index++) {
				different = (byte) (bytesLeft[index] ^ bytesRight[index]);
				if (different != 0) {
					offsets = offsets + " " + index;
				}
			}
		}
		return "Base64 data has obtained the same size, but its displacements are different:" + offsets;
	}
	
}
