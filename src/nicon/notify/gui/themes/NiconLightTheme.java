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
    
    private String bakcgroundPanel="ffffff";
    private String titleForeground="3d3d3d";
    private String messageForeground="3d3d3d";
    
    private String titleWarningForeground="ff6400";
    private String titleErrorForeground="ff000c";
    private String titleOKForeground="76b901";
    
    private static NiconLightTheme instance;

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
