/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.notify.gui.themes;

/**
 *
 * @author frederick
 */
public class NiconDarkTheme extends NiconTheme{
    
    private final String bakcgroundPanel="232323";
    private final String titleForeground="d2d2d2";
    private final String messageForeground="d2d2d2";
    
    private final String titleWarningForeground="ff6400";
    private final String titleErrorForeground="ff000c";
    private final String titleOKForeground="73d50b";
    
    private static NiconDarkTheme instance;

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
    
    public static NiconDarkTheme getInstance(){
        if(instance==null){
            instance=new NiconDarkTheme();
        }
        return instance;
    }
    
}
