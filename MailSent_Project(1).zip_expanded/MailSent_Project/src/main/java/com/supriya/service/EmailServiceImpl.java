package com.supriya.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.supriya.entity.Entity;
@Service
public class EmailServiceImpl implements EmailService {
@Autowired
private JavaMailSender javaMailSender;
@Value("${spring.mail.username}")
private String sender;
@Override
public String sendSimpleMail(Entity entity) {
SimpleMailMessage mailMessage = new SimpleMailMessage();
mailMessage.setFrom(sender);
mailMessage.setTo(entity.getRecipient());
mailMessage.setText(entity.getMsgBody());
mailMessage.setSubject("Anudip Spring boot Mail sending");
javaMailSender.send(mailMessage);
return "Mail Sent Successfully...";}}