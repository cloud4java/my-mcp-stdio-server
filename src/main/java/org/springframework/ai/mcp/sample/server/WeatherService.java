/*
* Copyright 2024 - 2024 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* https://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.springframework.ai.mcp.sample.server;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Service
public class WeatherService {

	private static final String BASE_URL = "https://api.weatherstack.com/current";

	private String apiKey = System.getenv("WEATHER_API_KEY");

	private final RestClient restClient;

	public WeatherService() {

		this.restClient = RestClient.builder()
			.baseUrl(BASE_URL)
			.defaultHeader("Accept", "application/geo+json")
			.defaultHeader("User-Agent", "WeatherApiClient/1.0 (your@email.com)")
			.build();
	}

	/**
	 * Get forecast for a specific location in Brazil
	 * @param location location name (e.g. "Campinas")
	 * @return The forecast for the given location in Brazil
	 * @throws RestClientException if the request fails
	 */
	@Tool(description = "MY OWN Get weather forecast for a specific latitude/longitude")
	public String getWeatherForecastBrazil(String location) {
		String uri = "?access_key=" + apiKey + "&query=" + location;
		String forecastText = restClient.get().uri(uri).retrieve().body(String.class);

		return forecastText;
	}

	public static void main(String[] args) {
		WeatherService client = new WeatherService();
		System.out.println(client.getWeatherForecastBrazil("Campinas"));
	}

}