package juicemachine.milkshakes;

public class JuiceMachineProcessorTest {
	
	public static void main(String[] args) {
//		test01();
//		test02();
		test03();	
	}
	
	static void test01() {
		//
		Result result = run(TestData.TEST_01_INPUT);
		System.out.println(result);
	}

	static void test02() {
		//
		Result result = run(TestData.TEST_02_INPUT);
		System.out.println(result);
	}

	static void test03() {
		//
		Result result = run(TestData.TEST_03_INPUT);
		System.out.println(result);
	}

	
	private static Result run(BulkOrder[] bulkOrders) {
		
		JuiceMachinePriorityQueueProcessor juiceMachine 
			= new JuiceMachinePriorityQueueProcessor(bulkOrders);
		
		Result result = juiceMachine.process();
		
		return result;
		
	}

}
