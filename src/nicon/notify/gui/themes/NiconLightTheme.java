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
    
    private final String bakcgroundPanel="ffffff";
    private final String titleForeground="3d3d3d";
    private final String messageForeground="3d3d3d";
    
    private final String titleWarningForeground="f39c12";
    private final String titleErrorForeground="e74c3c";
    private final String titleOKForeground="3498db";
    
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
