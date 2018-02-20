package com.orasi.core.by.angular.internal;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.List;

/*
 * Original Code from https://github.com/paul-hammant/ngWebDriver
 */

public class ByAngularRepeater extends ByAngular.BaseBy {

    public ByAngularRepeater(JavascriptExecutor jse, String repeater) {
        super(jse);
        this.repeater = repeater;
    }

    private String repeater;

    public ByAngularRepeaterRow row(int row) {
        return new ByAngularRepeaterRow(jse, repeater, row);
    }

    public ByAngularRepeaterColumn column(String column) {
        return new ByAngularRepeaterColumn(jse, repeater, column);
    }


    private String makeJsBy(String oneOrAll) {    	
        return
              
        		"var using = arguments[0] ||document;\n" +
                "var repeater = '" + repeater + "';\n" +
                "\n" +
                "var rows = [];\n" +
                "var prefixes = ['ng-', 'ng_', 'data-ng-', 'x-ng-'];\n" +
                "for (var p = 0; p < prefixes.length; ++p) {\n" +
                "  var attr = prefixes[p] + 'repeat';\n" +
                "  var repeatElems = using.querySelectorAll('[' + attr + ']');\n" +
                "  attr = attr.replace(/\\\\/g, '');\n" +
                "  for (var i = 0; i < repeatElems.length; ++i) {\n" +
                "    if (repeatElems[i].getAttribute(attr).indexOf(repeater) != -1) {\n" +
                "      rows.push(repeatElems[i]);\n" +
                "    }\n" +
                "  }\n" +
                "}\n" +
                "return rows" + oneOrAll + ";";
    }

    @Override
    public WebElement findElement(SearchContext context) {
        if (context instanceof WebDriver) {
            context = null;
        }
        
        Object o = jse.executeScript(makeJsBy("[0]"), context);
        errorIfNull(o);
        Field privateStringField = null;
        try {
        	privateStringField = o.getClass().getDeclaredField("foundBy");
        	privateStringField.setAccessible(true);
        	privateStringField.set(o, o.toString().replace("unknown locator", "ng-repeater: " + repeater));
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
      
        return (WebElement) o;
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<WebElement> findElements(SearchContext searchContext) {
        if (searchContext instanceof WebDriver) {
            searchContext = null;
        }
        
        Object o = jse.executeScript(makeJsBy(""), searchContext);
        errorIfNull(o);
        
        return (List<WebElement>) o;
    }

    @Override
    public String toString() {
        return "repeater(" + repeater + ')';
    }
}
