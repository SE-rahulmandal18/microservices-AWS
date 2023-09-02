package com.example.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class LoggingGatewayFilterFactory extends AbstractGatewayFilterFactory<LoggingGatewayFilterFactory.Config> {

	private final Logger logger = LoggerFactory.getLogger(LoggingGatewayFilterFactory.class);
	
	public LoggingGatewayFilterFactory() {
		super(Config.class);
	}
	
	@Override
	public GatewayFilter apply(Config config) {
		
		return (exchange, chain) -> {
			
			//pre-processing
			if(config.isPreLogger()) {
				logger.info("Pre GatewayFiler Logging: " + config.getBaseMessage());
			}
			
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				//Post-processing
				if(config.isPostLogger()) {
					logger.info("Post GatewayFiler Logging: " + config.getBaseMessage());
				}
			}));
		};
	   
	}
	
	
	public static class Config {

		public Config(String baseMessage, boolean preLogger, boolean postLogger) {
			super();
			this.baseMessage = baseMessage;
			this.preLogger = preLogger;
			this.postLogger = postLogger;
		}
		
		public Config() {
			
		}
		
		//Specify your configuration
		private String baseMessage;
		private boolean preLogger;
		private boolean postLogger;
		public String getBaseMessage() {
			return baseMessage;
		}
		public void setBaseMessage(String baseMessage) {
			this.baseMessage = baseMessage;
		}
		public boolean isPreLogger() {
			return preLogger;
		}
		public void setPreLogger(boolean preLogger) {
			this.preLogger = preLogger;
		}
		public boolean isPostLogger() {
			return postLogger;
		}
		public void setPostLogger(boolean postLogger) {
			this.postLogger = postLogger;
		}
		
		@Override
		public String toString() {
			return "Config [baseMessage=" + baseMessage + ", preLogger=" + preLogger + ", postLogger=" + postLogger
					+ ", getBaseMessage()=" + getBaseMessage() + ", isPreLogger()=" + isPreLogger()
					+ ", isPostLogger()=" + isPostLogger() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
					+ ", toString()=" + super.toString() + "]";
		}
			
		
	}
	


}
	
	