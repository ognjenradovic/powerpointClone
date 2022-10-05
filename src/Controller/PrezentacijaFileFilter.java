package Controller;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class PrezentacijaFileFilter extends FileFilter {
		@Override
		public String getDescription() {
			return "Prezentacija file (*.prezentacija)";
		}
		@Override
		public boolean accept(File f) {
			return (f.isDirectory() || f.getName().toLowerCase().endsWith(".prezentacija"));
		}
	}