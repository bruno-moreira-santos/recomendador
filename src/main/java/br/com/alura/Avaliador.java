package br.com.alura;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.common.RandomUtils;

public class Avaliador {

	public static void main(String[] args) throws IOException, TasteException {
		
		// fixa a aleatoriedade
		// sem essa instrução e executando várias vezes, dará resultados diferentes
		// ou seja, é mantido o primeiro resultado para todos os testes
		RandomUtils.useTestSeed();
		
		File file = new File("dados.csv");
		DataModel dataModel = new FileDataModel(file); 
		
		RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
		RecommenderBuilder builder = new RecomendadorDeProdutosBuilder();
		double margemErro = evaluator.evaluate(builder, null, dataModel, 0.9, 1.0);
		System.out.println(margemErro);
	}

}
