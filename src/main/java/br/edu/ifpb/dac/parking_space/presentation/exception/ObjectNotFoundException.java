package br.edu.ifpb.dac.parking_space.presentation.exception;

public class ObjectNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String object, String fieldName, Object field) {
		super("Não foi encontrado " + object + " com " + fieldName+ " " + field);
	}
}
