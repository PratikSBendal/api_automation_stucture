package jiffy_test;

import org.testng.annotations.Test;

import jiffy_config.JiffyConfig;
import jiffy_mailreport.JiffyEmail;
import post_create_customer.CreateCustomer;
import post_drawdown.DrawDown;
import post_upload_document.UploadDocument;
import post_utr_update.UtrUpdate;

public class JiffyTest {
		
	
@Test

public void testRun() throws Exception
{
	JiffyConfig config= new JiffyConfig();
	JiffyEmail email = new JiffyEmail();
	CreateCustomer customercreate = new CreateCustomer();
	UploadDocument docupload = new UploadDocument();
	DrawDown dradown = new DrawDown();
	UtrUpdate utr = new UtrUpdate();
	customercreate.crateCustoimerApi();
	String customeridpass =customercreate.customeridPassfunc();
	docupload.kycDocupload(customeridpass);
	Thread.sleep(100000);
	dradown.drawDownApi(customeridpass);
	String transcationidpass = dradown.transactionidPassfunc();
	Thread.sleep(100000);
	utr.utUpdate(customeridpass, transcationidpass);
	email.test();
}
}
