package org.bimserver.utils;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SwingUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(SwingUtil.class);
	
	public static final void setLookAndFeelToNice() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			LOGGER.error("", e);
		} catch (InstantiationException e) {
			LOGGER.error("", e);
		} catch (IllegalAccessException e) {
			LOGGER.error("", e);
		} catch (UnsupportedLookAndFeelException e) {
			LOGGER.error("", e);
		}
	}
}