package br.com.alura;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

public class Recomendador {
	
	final static String PRODUTOS_PATH = "dados.csv";
	final static String CURSOS_PATH = "cursos.csv";

	public DataModel getProdutosDataModel() throws IOException {
		final DataModel DATA_MODEL = getModelo(PRODUTOS_PATH);
		return DATA_MODEL;
	}

	public DataModel getCursosDataModel() throws IOException {
		final DataModel DATA_MODEL = getModelo(CURSOS_PATH);
		return DATA_MODEL;
	}
	
	private DataModel getModelo(final String PATH) throws IOException {
		final File FILE = new File(PATH);
		final DataModel DATA_MODEL = new FileDataModel(FILE);
		return DATA_MODEL;
	}

}
