package br.edu.ifpb.dac.parking_space.presentation.exception;

public class TimeAlreadyScheduledException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TimeAlreadyScheduledException() {
		super("Já existe um estacionamento agendado para esse horário!");
	}

}
