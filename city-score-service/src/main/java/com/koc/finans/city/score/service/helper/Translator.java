package com.koc.finans.city.score.service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Translator {

   private static ResourceBundleMessageSource messageSource;

   @Autowired
   Translator(ResourceBundleMessageSource messageSource) {
      Translator.messageSource = messageSource;
   }

   public static String toLocale(String msg, Object[] args) {
      return messageSource.getMessage(msg, args, LocaleContextHolder.getLocale());
   }

   public static String toLocale(String msg) {
      return toLocale(msg, null);
   }

   public static String toLocaleSpecified(String msg, Object[] args, Locale locale) {
      return messageSource.getMessage(msg, args, locale);
   }

   public static String toLocaleSpecified(String msg, Locale locale) {
      return toLocaleSpecified(msg, null, locale);
   }
}