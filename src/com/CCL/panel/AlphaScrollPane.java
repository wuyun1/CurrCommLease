package com.CCL.panel;


import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.border.LineBorder;

import com.CCL.model.MTree_zixingche;

public class AlphaScrollPane extends JScrollPane {
    
    private static final long serialVersionUID = 1L;
    private boolean borderPaint = false;
    private boolean headerOpaquae = true;
    private boolean viewportBorderPaint = false;
    
    /**
     * This is the default constructor
     */
    public AlphaScrollPane() {
        super();
        initialize();
    }
    
    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(300, 200);
        setBackground(new Color(151, 188, 229));
        setOpaque(false);
        addPropertyChangeListener(new PropertyChangeAdapter());
    }
    
    private final class PropertyChangeAdapter implements
            PropertyChangeListener, Serializable {
        
        public void propertyChange(PropertyChangeEvent e) {
            String name = e.getPropertyName();
            if (name.equals("ancestor")) {
                JViewport header = getColumnHeader();
                if (header != null) {
                    // header.setBackground(getBackground());
                    JComponent view = (JComponent) header.getView();
                    if (view instanceof MTree_zixingche)
                        view.setOpaque(isOpaque());
                    header.setOpaque(headerOpaquae);
                }
                getViewport().setOpaque(isOpaque());// ʹ������ͼ͸��
                if (!viewportBorderPaint)
                    setViewportBorder(null);// ȡ��������ͼ�ı߿�
                if (!isBorderPaint())// ���Ʊ߿�
                    setBorder(null);
            }
            if (name.equals("background")) {
                setBorder(new LineBorder(getBackground(), 1, true));
            }
        }
    }
    
    public boolean isBorderPaint() {
        return borderPaint;
    }
    
    public void setBorderPaint(boolean borderPaint) {
        this.borderPaint = borderPaint;
    }
    
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        Component[] components = getComponents();
        for (Component component : components) {
            component.setEnabled(enabled);
        }
        Component view = getViewport().getView();
        if (view != null)
            view.setEnabled(enabled);
        if (getColumnHeader() != null)
            getColumnHeader().setEnabled(enabled);
    }
    
    public void setHeaderOpaquae(boolean headerOpaquae) {
        this.headerOpaquae = headerOpaquae;
    }
    
    public boolean isViewportBorderPaint() {
        return viewportBorderPaint;
    }
    
    public void setViewportBorderPaint(boolean viewportBorderPaint) {
        this.viewportBorderPaint = viewportBorderPaint;
    }
}

