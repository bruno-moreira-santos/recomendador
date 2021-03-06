package br.com.alura;

import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

public class RecomendaProdutos {
	
	public static void main(String[] args) throws IOException, TasteException {
		final DataModel produtosDataModel = new Recomendador().getProdutosDataModel();
		final Recommender recommender = new RecomendadorBuilder().buildRecommender(produtosDataModel);
		final List<RecommendedItem> recommend = recommender.recommend(2, 3);
		int index = 1;
		for (final RecommendedItem recommendation : recommend) {
			System.out.println(index + ". " + recommendation);
			index++;
		}
	}
}
