package com.prototype.mailserialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Mail implements Serializable{
	
	private String sender;
	private String receiver;
	private String title;
	private String content;
	private String date;
	private Attachment attachment = new Attachment();
	
	public Mail deepClone() throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(this);
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		return (Mail) ois.readObject();
	}
	
	public void show(){
		System.out.println("Sender : " + sender);
		System.out.println("Receiver : " + receiver);
		System.out.println("Title : " + title);
		System.out.println("Content : " + content);
		System.out.println("Date : " + date);
		System.out.println("AttachmentName : " + attachment.getName());
		System.out.println("----------------------------");
	}
	
	public void setAttachment(String attachmentName) {
		this.attachment.setName(attachmentName);
	}
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
