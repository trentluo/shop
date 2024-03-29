package com.rency.shop.web.resolver;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

public class VelocityMultipleLayoutViewResolver extends VelocityViewResolver {
	
	private static final Logger logger = LoggerFactory.getLogger(VelocityMultipleLayoutViewResolver.class);
	
	/** 布局配置 */
    private Map<String, String> mappings = new HashMap<String, String>();
	
	@Override
	protected Class<?> requiredViewClass() {
		return VelocityLayoutView.class;
	}

	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		if(viewName.endsWith(".htm")){//不知为何会多出这个后缀，费解 ?????????
			viewName = viewName.replace(".htm", "");
		}
		VelocityLayoutView view = (VelocityLayoutView) super.buildView(viewName);
		if(!mappings.isEmpty()){
			for(Map.Entry<String, String> entry : mappings.entrySet()){
				String mappingRegexp = StringUtils.replace(entry.getKey(), "*", ".*");
				// 匹配视图
                if (viewName.matches(mappingRegexp)) {
                	logger.info("view["+viewName+"] match layout["+entry.getValue()+"]");
                    view.setLayoutUrl(entry.getValue());
                    return view;
                }
			}
			logger.info("layout view not found with["+viewName+"]");
		}
		return view;
	}

	public Map<String, String> getMappings() {
		return mappings;
	}

	public void setMappings(Map<String, String> mappings) {
		this.mappings = mappings;
	}
}
