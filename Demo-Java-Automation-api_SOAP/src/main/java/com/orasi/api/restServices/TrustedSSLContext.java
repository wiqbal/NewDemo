package com.orasi.api.restServices;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;

import com.orasi.api.WebServiceException;
import com.orasi.utils.TestReporter;
/**
 * Intended to override the default Trust actions for SSL content to accept all issued certificates
 *
 * @author Justin Phlegar
 *
 */
public class TrustedSSLContext {
    public static CloseableHttpClient buildHttpClient() {
        return buildHttpClient(60);
    }
    /**
     * Build a HttpClient that associates an overridden SSL Context
     *
     * @return httpClient that will accept all SSL connections
     */
    public static CloseableHttpClient buildHttpClient(int timeout) {
        TestReporter.logTrace("Entering TrustedSSLContext#buildHttpClient");
        TestReporter.logTrace("Creating Http Client Builder object");
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        TestReporter.logTrace("Creating SSL Context that will accept all server certificates");
        SSLContext sslContext = null;
        try {
            TestReporter.logTrace("Generate custom SSL Context to override isTrusted");
            sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
                public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    return true;
                }
            }).build();
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
            throw new WebServiceException("Failed to create custom SSL Context", e);
        }
        TestReporter.logTrace("Successfully built custom SSL Context");
        TestReporter.logTrace("Associate custom SSL Context to Http Client");
        clientBuilder.setSSLContext(sslContext);
        TestReporter.logTrace("Creating a custom Socket Factory to register https connections to use");
        SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
        TestReporter.logTrace("Register https connections to use new Socket Factory");
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", sslSocketFactory)
                .build();
        TestReporter.logTrace("Associating Socket Registry to Http Client");
        PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        clientBuilder.setConnectionManager(connMgr);
        TestReporter.logTrace("Building config with timeouts of [ " + (timeout * 1000) + " ] seconds");
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(timeout * 1000).setConnectionRequestTimeout(timeout * 1000).setSocketTimeout(timeout * 1000).build();
        TestReporter.logTrace("Building new Http Client");
        CloseableHttpClient client = clientBuilder.setDefaultRequestConfig(requestConfig).build();
        TestReporter.logTrace("Exiting TrustedSSLContext#buildHttpClient");
        return client;
    }
}