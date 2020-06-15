package io.github.w7mike.service;

import io.github.w7mike.NoteConfigurationProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class InfoController {


    private DataSourceProperties datasource;
    private NoteConfigurationProperties allowMultipleNotesProperty;

    public InfoController(DataSourceProperties datasource, NoteConfigurationProperties allowMultipleNotesProperty ){
        this.datasource = datasource;
        this.allowMultipleNotesProperty = allowMultipleNotesProperty;

    }


    @GetMapping("/info/url")
    String url(){
        return datasource.getUrl();
    }

    @GetMapping("/info/multipleNotes")
    boolean note(){
        return allowMultipleNotesProperty.getTemplate().isAllowMultipleNotes();
    }


}
