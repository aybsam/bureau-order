package com.lismart.smartregie.config;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.ResourceBundle;

@Component
public class ResourceBundleConfiguration implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Messages.setResolver(new Messages.Resolver() {
            private static final String BASE_NAME = "com.lismart.smartregie.i18n.messages";
            public String getMessage(String message, Object... params) {
                ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, Faces.getLocale());
                if (bundle.containsKey(message)) {
                    message = bundle.getString(message);
                }
                return params.length > 0 ? MessageFormat.format(message, params) : message;
            }
        });
    }
}