package br.com.alura;

import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

public class RecomendaCursos {

	public static void main(String[] args) throws IOException, TasteException {
		final DataModel cursosDataModel = new Recomendador().getCursosDataModel();
		final Recommender recommender = new RecomendadorBuilder().buildRecommender(cursosDataModel);
		final List<RecommendedItem> recommendations = recommender.recommend(15, 10);
		int index = 1;
		for (final RecommendedItem recommendation : recommendations) {
			System.out.println(index + ". " + recommendation);
			index++;
		}
	}

}
