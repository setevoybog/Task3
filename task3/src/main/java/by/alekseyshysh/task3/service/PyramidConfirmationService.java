package by.alekseyshysh.task3.service;

import by.alekseyshysh.task3.entity.AbstractFigure;
import by.alekseyshysh.task3.entity.RegularPyramid;

public interface PyramidConfirmationService {
	
	public boolean confirmPyramidBaseOnCordinatePlane(RegularPyramid regularPyramid);
	
}
