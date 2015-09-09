<%@ page
    language="java"
    contentType="application/javascript; charset=UTF-8"
    trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

/**
 * Returns servlet context aware URL, ready to use for AJAX calls and resource
 * loading from JS.
 * 
 * This script must be included before any other JS sources that want to use
 * `url()`.
 * 
 * @param {string}
 *            path a servlet context unaware path of URL, like `api/users`
 * @returns {string} servlet context aware URL
 * @author madhead
 */
function url(path){
    return '<spring:url value="/" />' + path;
}