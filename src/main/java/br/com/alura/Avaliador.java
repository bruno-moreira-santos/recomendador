package br.com.alura;

import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.common.RandomUtils;

public class Avaliador {

	public static void main(String[] args) throws IOException, TasteException {
		
		// fixa a aleatoriedade
		// sem essa instrução e executando várias vezes, dará resultados diferentes
		// ou seja, é mantido o primeiro resultado para todos os testes
		RandomUtils.useTestSeed();
		
		final DataModel produtosDataModel = new Recomendador().getProdutosDataModel();
		final DataModel cursosDataModel = new Recomendador().getCursosDataModel();
		
		final RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
		final RecommenderBuilder builder = new RecomendadorBuilder();
		double margemErro = evaluator.evaluate(builder, null, produtosDataModel, 0.9, 1.0);
		System.out.println("Margem de erro (produtos): " + margemErro);
		margemErro = evaluator.evaluate(builder, null, cursosDataModel, 0.9, 1.0);
		System.out.println("Margem de erro (cursos): " + margemErro);
	}

}
