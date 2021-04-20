package by.alekseyshysh.task3.observer.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.alekseyshysh.task3.entity.RegularPolygon;
import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.observer.FigureEvent;
import by.alekseyshysh.task3.service.RegularPolygonCalculationService;
import by.alekseyshysh.task3.service.impl.RegularPolygonCalculationServiceImpl;
import by.alekseyshysh.task3.warehouse.Warehouse;

public class RegularPolygonObserver extends FigureObserver {

	private static Logger logger = LogManager.getRootLogger();
	
	@Override
	public void parameterChanged(FigureEvent event) {
		RegularPolygon figure = (RegularPolygon) event.getSource();
		RegularPolygonCalculationService calculationService = new RegularPolygonCalculationServiceImpl();
		double area = calculationService.calculateArea(figure);
		double perimeter = calculationService.calculatePerimeter(figure);
		long id = figure.getId();
		Warehouse warehouse = Warehouse.getInstance();
		try {
			warehouse.updateParametersRegularPolygon(id, area, perimeter);
		} catch (FiguresException e) {
			logger.log(Level.ERROR, e);
		}
		logger.log(Level.DEBUG, figure);
	}
	
}
