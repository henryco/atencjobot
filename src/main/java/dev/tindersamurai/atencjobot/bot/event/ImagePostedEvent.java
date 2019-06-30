package dev.tindersamurai.atencjobot.bot.event;

import dev.tindersamurai.atencjobot.bot.ProkuratorBotEventListener;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.springframework.stereotype.Component;

@Component @Slf4j
public class ImagePostedEvent extends ProkuratorBotEventListener {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		log.info("image post event: {}", event);
		val message = event.getMessage();

		val avatarUrl = message.getAuthor().getAvatarUrl();
		val name = message.getAuthor().getName();
		val tag = message.getAuthor().getAsTag();

		val channelName = message.getChannel().getName();
		val channelId = message.getChannel().getId();

		val date = message.getCreationTime().toString();
		val type = message.getType();


		log.info("---AUTHOR---");
		log.info("TAG: {}", tag);
		log.info("NAME: {}", name);
		log.info("AVATAR: {}", avatarUrl);

		log.info("---CHANNEL---");
		log.info("NAME: {}", channelName);
		log.info("ID: {}", channelId);

		log.info("---CONTENT---");
		log.info("TYPE: {}", type);
		log.info("DATE: {}", date);

		val attachments = message.getAttachments();
		for (val a : attachments) {
			val fileName = a.getFileName();
			val image = a.isImage();
			val size = a.getSize();
			val url = a.getUrl();

			log.info("---ATTACHMENT---");
			log.info("NAME: {}", fileName);
			log.info("IMAGE: {}", image);
			log.info("SIZE: {}", size);
			log.info("URL: {}", url);
		}

		log.info("---END---");
	}
}