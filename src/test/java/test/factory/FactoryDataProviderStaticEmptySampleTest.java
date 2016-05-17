package test.factory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

/**
 * 
 * Test empty array returned from data provider.<br>
 * https://github.com/cbeust/testng/issues/1030
 *
 */
public class FactoryDataProviderStaticEmptySampleTest extends BaseFactory {

	@Factory(dataProvider = "dp")
	public FactoryDataProviderStaticEmptySampleTest(int n) {
		super(n);
	}

	@DataProvider(name = "dp")
	public static Object[][] dp() {
		return new Object[][] {};
	}
}
