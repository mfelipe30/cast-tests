package main.java.br.com.cast.comparator.service;

import java.util.Arrays;

import javax.xml.bind.ValidationException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.comparador.entidade.Documento;
import br.com.cast.comparador.enums.LadoEnum;
import br.com.cast.comparador.repositorio.DocumentoRepository;

@Service
public class ComparatorService {

	@Autowired
	public DocumentoRepository repository;

	public Documento salvar(Long id, String dados, LadoEnum ladoEnum) throws Exception {
		Documento documento = null;
		
		if(validador(id, dados)){
			documento = repository.findById(id);
			
			if (documento == null) {
				documento = new Documento();
				documento.setId(id);
			}
	
			if(LadoEnum.LEFT.equals(ladoEnum)) {
				documento.setEsquerda(dados);
			} else if(LadoEnum.RIGHT.equals(ladoEnum)) {
				documento.setDireita(dados);
			}
			
			documento = repository.save(documento);
		}
		
		return documento;
	}
	
	public boolean validador(Long id, String data) throws ValidationException {
		boolean isValid = true;

		if (StringUtils.isEmpty(data)) {
			isValid = false;
		}
		
		return isValid;
	}
	
	public String validadorBase64Dado(Long id) {
		Documento documento = repository.findById(id);
		if (documento == null) {
			return "Dados nao encontrado.";
		}

		if (!StringUtils.isNotBlank(documento.getEsquerda()) 
				|| !StringUtils.isNotBlank(documento.getDireita())) {
			return "Dados Base64 faltando.";
		}
		
		byte[] bytesLeft = documento.getEsquerda().getBytes();
		byte[] bytesRight = documento.getDireita().getBytes();

		boolean resultado = Arrays.equals(bytesLeft, bytesRight);

		String offsets = "";

		if (resultado) {
			return "Dados Base64 são iguais.";
		} else if (bytesLeft.length != bytesRight.length) {
			return "Dados Base64 não tem o mesmo tamanho.";
		} else {
			byte different = 0;
			for (int index = 0; index < bytesLeft.length; index++) {
				different = (byte) (bytesLeft[index] ^ bytesRight[index]);
				if (different != 0) {
					offsets = offsets + " " + index;
				}
			}
		}
		return "Dados Base64 obtiveram o mesmo tamanho, mas seus deslocamentos são diferentes:" + offsets;
	}

}
