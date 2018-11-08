package Tests;

import Classes.Article;
import Classes.Articles2Shop;
import Classes.Currency;
import Classes.StockService;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class addArticleStrictQuantity {
	StockService stock_mock;
	Articles2Shop shop;
	String article = "chaussure";
	Currency prix = new Currency(10, "€");
	//List<Article> panier = new

	@Before
	public void creation(){
		stock_mock = EasyMock.createStrictMock(StockService.class);
		shop = new Articles2Shop(stock_mock);
	}

	@Test
	public void normal(){
		EasyMock.expect(stock_mock.available(article)).andReturn(5);

		stock_mock.buy(article);
		stock_mock.buy(article);
		stock_mock.buy(article);

		EasyMock.expect(stock_mock.getPrix(article)).andReturn(prix);

		EasyMock.replay(stock_mock);

		assertEquals(3, shop.addArticleStrictQuantity(article, 3));

		EasyMock.verify(stock_mock);
	}

	@Test
	public void pasAssezEnStock(){
		EasyMock.expect(stock_mock.available(article)).andReturn(2);

		EasyMock.replay(stock_mock);

		assertEquals(0, shop.addArticleStrictQuantity(article, 3));

		EasyMock.verify(stock_mock);
	}
}
