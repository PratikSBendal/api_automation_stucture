package jiffy_mailreport;
import java.io.File;

import com.mailgun.api.v3.MailgunMessagesApi;
import com.mailgun.client.MailgunClient;
import com.mailgun.model.message.Message;
import com.mailgun.model.message.MessageResponse;

import io.github.cdimascio.dotenv.Dotenv;
import jiffy_config.JiffyConfig;

public class JiffyEmail extends JiffyConfig {
	public MessageResponse test()
	{
	env();
	 MailgunMessagesApi mailgunMessagesApi = MailgunClient.config(mailgunsecret)
		        .createApi(MailgunMessagesApi.class);

		    Message message = Message.builder()
		        .from("API <pratik.bendal16@gmail.com>")
		        .to("pratik.bendal16@gmail.com>")
		        .subject("Hello")
		        .text("Testing out some Mailgun awesomeness!").attachment(new File("....reportpath/test-output/emailable-report.html"))
		        .build();
		    
		    return mailgunMessagesApi.sendMessage(mailgundomain, message);
}
	
	
}