package com.davve.productapi.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.davve.productapi.model.Product;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class FakeStoreResource {
	
	private FakeStoreResource() {
		throw new IllegalStateException("Utility class");
	}
	
	public static List<Product> getAllProducts() throws URISyntaxException {
		try {
			Gson gson = new Gson();
			String jsonString = fetchDataFromURL("https://fakestoreapi.com/products");
			String json = jsonString;
			Type productListType = new TypeToken<List<Product>>() {}.getType();
			return gson.fromJson(json, productListType);
			//return 
		} catch (IOException e) {
			return Collections.emptyList();
		}
	}

	public static Product getProductById(List<Product> products, Long id) {
		for (Product product : products) {
			if (Objects.equals(product.getId(), id)) {
				return product;
			}
		}
		return null;
	}

	public static String fetchDataFromURL(String urlString) throws IOException, URISyntaxException {
		URL url = new URI(urlString).toURL();
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			return response.toString();
		} else {
			throw new IOException("Failed to fetch data from URL. Response code: " + responseCode);
		}
	}
}
