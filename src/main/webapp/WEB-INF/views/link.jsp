<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <%@ page session="false"%>
                <html>

                <head>
                    <title>URL Shortener</title>
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
                    <h3>Create short url</h3>

                    <c:url var="addAction" value="/link/add"></c:url>

                    <form:form action="${addAction}" commandName="url">
                        <table>
                            <c:if test="${!empty url.sourceLink}">
                                <tr>
                                    <td>
                                        <form:label path="id">
                                            <spring:message text="ID" />
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="id" readonly="true" size="8" disabled="true" />
                                        <form:hidden path="id" />
                                    </td>
                                </tr>
                            </c:if>
                            <tr>
                                <td>
                                    <form:label path="sourceLink">
                                        <spring:message text="Source Link" />
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="sourceLink" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="password">
                                        <spring:message text="Password" />
                                    </form:label>
                                </td>
                                <td>
                                    <form:password path="password" />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="<spring:message text=" Shrink "/>" />
                                </td>
                            </tr>
                        </table>
                    </form:form>
                    <a href="${linkGeneration}">${linkGeneration}</a>
                </body>

                </html>