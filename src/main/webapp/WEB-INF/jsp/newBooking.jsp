<!DOCTYPE html>
<html lang="en">
<head>
	<title>New Booking</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/custom.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form action="bookings/new" method="post" class="">
			<div class="form-group">
				<label for="name">Name</label> <input type="text" class="form-control" id="name" name="name" placeholder="name">
			</div>
			<div class="form-group">
				<label for="email">email</label> <input type="email" class="form-control" id="email" name="email" placeholder="email">
			</div>
			<div class="form-group">
				<label for="phone">phone</label> <input type="tel" class="form-control" id="phone" name="phone" placeholder="phone">
			</div>
			<div class="form-group">
				<label for="flat">flatNo</label> <input type="number" class="form-control" id="flatNo" name="flatNo" placeholder="flatNo">
			</div>
			<div class="form-group">
				<label for="reason">reason</label> <input type="number" class="form-control" id="reason" name="reason" placeholder="reason">
			</div>
			<div class="form-group">
				<label for="bokingFrom">bokingFrom</label> <input type="datetime" class="form-control" id="bokingFrom" name="bokingFrom" placeholder="bokingFrom">
			</div>
			<div class="form-group">
				<label for="bookingTo">fbookingTolatNo</label> <input type="datetime" class="form-control" id="bookingTo" name="bookingTo" placeholder="bookingTo">
			</div>
			<button type="submit" class="btn btn-default">Book</button>
		</form>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>
</html>