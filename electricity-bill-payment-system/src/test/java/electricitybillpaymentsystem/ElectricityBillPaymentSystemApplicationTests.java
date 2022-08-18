package electricitybillpaymentsystem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import electricitybillpaymentsystem.controller.BillController;
import electricitybillpaymentsystem.controller.ConnectionController;
import electricitybillpaymentsystem.controller.CustomerController;
import electricitybillpaymentsystem.controller.ReadingController;

@SpringBootTest
class ElectricityBillPaymentSystemApplicationTests {
	
	@Autowired
	CustomerController customerController;

	@Autowired
	BillController billController;
	
	@Autowired
	ConnectionController connectionController;
	
	@Autowired
	ReadingController readingController;
	
	@Test
	void contextLoads() {
		assertThat(customerController).isNotNull();
		assertThat(billController).isNotNull();
		assertThat(connectionController).isNotNull();
		assertThat(readingController).isNotNull();
	}

}
