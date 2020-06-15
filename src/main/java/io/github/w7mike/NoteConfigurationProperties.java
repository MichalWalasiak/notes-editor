package io.github.w7mike;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("note")
public class NoteConfigurationProperties {

    Template template;

    public Template getTemplate() {
        return template;
    }

    void setTemplate(final Template template) {
        this.template = template;
    }

    public static class Template{

        private boolean allowMultipleNotes;

        public boolean isAllowMultipleNotes() {
            return allowMultipleNotes;
        }

        void setAllowMultipleNotes(final boolean allowMultipleNotes) {
            this.allowMultipleNotes = allowMultipleNotes;
        }
    }

}
