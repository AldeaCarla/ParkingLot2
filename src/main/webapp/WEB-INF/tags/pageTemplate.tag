<%@tag description="Base page template" pageEncoding="UTF-8"%>
<%@attribute name="pageTitle" required="true"%>
<%@attribute name="aboutParkingLot"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${pageTitle}</title>
</head>
<body>
<header>
    <h1>${pageTitle}</h1>
    <h2>${aboutParkingLot}</h2>
</header>

<main>
    <jsp:doBody/>
</main>

<
</body>
</html>
