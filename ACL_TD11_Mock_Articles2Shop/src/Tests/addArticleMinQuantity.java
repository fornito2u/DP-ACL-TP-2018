package Tests;

import Classes.Articles2Shop;
import Classes.Currency;
import Classes.StockService;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class addArticleMinQuantity {
	StockService stock_mock;
	Articles2Shop shop;
	String article = "chaussure";
	Currency prix = new Currency(10, "€");

	@Before
	public void creation(){
		stock_mock = EasyMock.createStrictMock(StockService.class);
		shop = new Articles2Shop(stock_mock);
	}

	@Test
	public void normal(){
		stock_mock.buy(article);
		stock_mock.buy(article);
		stock_mock.buy(article);

		EasyMock.expect(stock_mock.getPrix(article)).andReturn(prix);

		EasyMock.replay(stock_mock);

		assertEquals(3, shop.addArticleMinQuantity(article,3));

		EasyMock.verify(stock_mock);
	}

	@Test
	public void pasAssezEnStock(){
		stock_mock.buy(article);
		stock_mock.buy(article);

		stock_mock.buy(article);
		EasyMock.expectLastCall().andThrow(new IllegalArgumentException());

		EasyMock.expect(stock_mock.getPrix(article)).andReturn(prix);

		EasyMock.replay(stock_mock);

		assertEquals(2, shop.addArticleMinQuantity(article, 3));

		EasyMock.verify(stock_mock);
	}
}
