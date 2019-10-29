<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <style type="text/css">
                .tg {
                    border-collapse: collapse;
                    border-spacing: 0;
                    border-color: #ccc;
                }
                
                .tg td {
                    font-family: Arial, sans-serif;
                    font-size: 14px;
                    padding: 10px 5px;
                    border-style: solid;
                    border-width: 1px;
                    overflow: hidden;
                    word-break: normal;
                    border-color: #ccc;
                    color: #333;
                    background-color: #fff;
                }
                
                .tg th {
                    font-family: Arial, sans-serif;
                    font-size: 14px;
                    font-weight: normal;
                    padding: 10px 5px;
                    border-style: solid;
                    border-width: 1px;
                    overflow: hidden;
                    word-break: normal;
                    border-color: #ccc;
                    color: #333;
                    background-color: #f0f0f0;
                }
                
                .tg .tg-4eph {
                    background-color: #f9f9f9
                }
            </style>
        </head>

        <body>
            <c:if test="${!empty urlLits}">
                <table class="tg">
                    <tr>
                        <th width="80">ID</th>
                        <th width="120">Source Link</th>
                        <th width="120">Short Link</th>
                        <th width="60">Date Create</th>
                        <th width="60">View</th>
                    </tr>
                    <c:forEach items="${urlLits}" var="url">
                        <tr>
                            <td>${url.id}</td>
                            <td>${url.sourceLink}</td>
                            <td>${url.shortLink}</td>
                            <td>${url.dateCreate}</td>
                            <td>${url.view}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </body>

        </html>