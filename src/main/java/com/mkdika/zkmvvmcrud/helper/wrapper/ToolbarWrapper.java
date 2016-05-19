package com.mkdika.zkmvvmcrud.helper.wrapper;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public class ToolbarWrapper {

    private Boolean visible = false;
    private Boolean disabled = false;
    
    public ToolbarWrapper(Boolean visible,Boolean disabled) {
        this.visible = visible;
        this.disabled = disabled;
    }
    
    public void setState(Boolean visible,Boolean disabled) {
        this.visible = visible;
        this.disabled = disabled;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }      
}
