/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.notify.gui.themes;

/**
 *
 * @author frederick
 */
public class NiconLightTheme extends NiconTheme{
    
    private final String bakcgroundPanel;
    private final String titleForeground;
    private final String messageForeground;    
    private final String titleWarningForeground;
    private final String titleErrorForeground;
    private final String titleOKForeground;
    
    private static NiconLightTheme instance;
    
    private NiconLightTheme(){
        this.bakcgroundPanel = "ffffff";
        this.titleForeground = "3d3d3d";
        this.messageForeground = "3d3d3d";
        this.titleWarningForeground = "f39c12";
        this.titleErrorForeground = "e74c3c";
        this.titleOKForeground = "3498db";
    }

    @Override
    public String getBakcgroundPanel() {
        return bakcgroundPanel;
    }
    
    @Override
    public String getTitleForeground() {
        return titleForeground;
    }

    @Override
    public String getMessageForeground() {
        return messageForeground;
    }
    @Override
    public String getTitleWarningForeground() {
        return titleWarningForeground;
    }
    
    @Override
    public String getTitleErrorForeground() {
        return titleErrorForeground;
    }
    
    @Override
    public String getTitleOKForeground() {
        return titleOKForeground;
    }
    
    public static NiconLightTheme getInstance(){
        if(instance==null){
            instance=new NiconLightTheme();
        }
        return instance;
    }
    
}
