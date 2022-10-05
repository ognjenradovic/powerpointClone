package Controller;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class MyFileFilter extends FileFilter {
		@Override
		public String getDescription() {
			return "RuDok file (*.rudok)";
		}
		@Override
		public boolean accept(File f) {
			return (f.isDirectory() || f.getName().toLowerCase().endsWith(".rudok"));
		}
	}