package br.com.cast.comparator.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Document {

	private static final String LEFT  = "\n left=";
	private static final String RIGHT = "\n right=";

	@Id
	private long id;

	@Lob
	@Column(length = 32000)
	private String left;

	@Lob
	@Column(length = 32000)
	private String right;

	public Document() {
	}

	/**
	 * Document construct
	 * 
	 * @param id
	 * @param left
	 * @param right
	 */
	public Document(long id, String left, String right) {
		this.id = id;
		this.left = left;
		this.right = right;
	}

	/**
	 * Get id of Document
	 * 
	 * @return long
	 */
	public long getId() {
		return id;
	}

	/**
	 * Set id of Document
	 * 
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Get left of Document
	 * 
	 * @return base64
	 */
	public String getLeft() {
		return left;
	}

	/**
	 * Set left of Document
	 * @param left
	 */
	public void setLeft(String left) {
		this.left = left;
	}

	/**
	 * Get Right of DOcument
	 * @return base64
	 */
	public String getRight() {
		return right;
	}

	/**
	 * Set right of Document
	 * @param right
	 */
	public void setRight(String right) {
		this.right = right;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (id != other.id)
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Document[" + getId() + "]" + LEFT + getLeft() + RIGHT + getRight();
	}
}