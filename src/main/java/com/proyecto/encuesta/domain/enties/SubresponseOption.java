package com.proyecto.encuesta.domain.enties;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SubresponseOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private int subresponse_number;
    @Embedded
    Audit audit = new Audit();
     @ManyToOne
    @JoinColumn(name = "responseoption_id")
    private ResponseOption responseOption ;
    
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String component_html;
    
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String subresponse_text;

    
    public SubresponseOption() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public int getSubresponse_number() {
        return subresponse_number;
    }

    public void setSubresponse_number(int subresponse_number) {
        this.subresponse_number = subresponse_number;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public ResponseOption getResponseOption() {
        return responseOption;
    }

    public void setResponseOption(ResponseOption responseOption) {
        this.responseOption = responseOption;
    }

    public String getComponent_html() {
        return component_html;
    }

    public void setComponent_html(String component_html) {
        this.component_html = component_html;
    }

    public String getSubresponse_text() {
        return subresponse_text;
    }

    public void setSubresponse_text(String subresponse_text) {
        this.subresponse_text = subresponse_text;
    }

    
}
