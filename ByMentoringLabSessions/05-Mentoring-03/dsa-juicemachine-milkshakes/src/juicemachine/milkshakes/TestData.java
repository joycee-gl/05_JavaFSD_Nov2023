package juicemachine.milkshakes;

public class TestData {

	public static BulkOrder[] TEST_01_INPUT = 
			new BulkOrder[] {
					new BulkOrder(JuiceType.MANGO, 5),
					new BulkOrder(JuiceType.ORANGE, 4),
					new BulkOrder(JuiceType.PINE_APPLE, 4)
			};
	
	public static BulkOrder[] TEST_02_INPUT = 
			new BulkOrder[] {
					new BulkOrder(JuiceType.MANGO, 3),
					new BulkOrder(JuiceType.ORANGE, 0),
					new BulkOrder(JuiceType.PINE_APPLE, 0)
			};
	
	public static BulkOrder[] TEST_03_INPUT = 
			new BulkOrder[] {
					new BulkOrder(JuiceType.MANGO, 1),
					new BulkOrder(JuiceType.ORANGE, 4),
					new BulkOrder(JuiceType.PINE_APPLE, 2)
			};
	
}
