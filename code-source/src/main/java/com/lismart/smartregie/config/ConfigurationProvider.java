package com.lismart.smartregie.config;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.config.Direction;
import org.ocpsoft.rewrite.servlet.config.Forward;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.Path;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

import javax.servlet.ServletContext;

// TODO : A supprimer ultérierement

@org.springframework.context.annotation.Configuration
@RewriteConfiguration
public class ConfigurationProvider extends HttpConfigurationProvider {

    @Override
    public Configuration getConfiguration(ServletContext servletContext) {
        return ConfigurationBuilder.begin()
                .addRule(Join.path("/login").to("/login.xhtml"))
                .addRule()
                .when(Direction.isInbound().and(Path.matches("/index.xhtml")))
                .perform(Forward.to("/users/list.xhtml?faces-redirect=true"));
    }

    @Override
    public int priority() {
        return 10;
    }
}
