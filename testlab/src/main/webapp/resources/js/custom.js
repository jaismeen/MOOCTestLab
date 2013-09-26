/**
 * Contains custom JavaScript code
 */
var urlHolder = new Object();

function loadTable() {
	$.get(urlHolder.records, function(response) {
		
 		$('#tableUsers').find('tbody').remove();
 		
 		alert("in loadTable()");
 		
 		alert(response.nodes[3].name+" "+response.nodes[3].incomingRelationships+" "+response.nodes[3].outgoingRelationship);
 		
 		for (var i=0; i<response.nodes.length; i++) {
			var row = '<tr>';
			row += '<td><input type="radio" name="index" id="index" value="'+i+'"></td>';
			row += '<td>' + response.nodes[i].name + '</td>';
			row += '<td>' + response.nodes[i].description + '</td>';
			//row += '<td>' + response.main[i].lastName + '</td>';
			//row += '<td>' + getRole(response.users[i].role) + '</td>';
			row += '</tr>';
	 		$('#tableUsers').append(row);
 		}
 		
 		$('#tableUsers').data('model', response.nodes);
		toggleForms('hide'); ;
		
		
		alert("out loadTable()");
 	});
}

function submitNewRecord() {
	
	alert("submitNewRecord "+$('#newName').val()+" "+$('#newDescription').val()+ " "+$('#newTransition').val());
	
	$.post(urlHolder.add, {
			name: $('#newName').val(),
			description: $('#newDescription').val(),
			type: $('#newTransition').val()
		}, 
		function(response) {
			
			alert("Submit New Record response.")
			
			if (response != null) {
				//loadTable();
				toggleForms('hide'); ;
				toggleCrudButtons('show');
				alert('Success! Record has been added.');
			} else {
				alert('Failure! An error has occurred!');
			}
		}
	);	
}

function submitDeleteRecord() {
	var selected = $('input:radio[name=index]:checked').val();
	
	$.post(urlHolder.del, {
			username: $('#tableUsers').data('model')[selected].username
		}, 
		function(response) {
			if (response == true) {
				loadTable(urlHolder.records);
				alert('Success! Record has been deleted.');
			} else {
				alert('Failure! An error has occurred!');
			}
		}
	);
}

function submitUpdateRecord() {
	$.post(urlHolder.edit, {
			username: $('#editUsername').val(),
			firstName: $('#editFirstName').val(),
			lastName: $('#editLastName').val(),
			role: $('#editRole').val()
		}, 
		function(response) {
			if (response != null) {
				loadTable();
				toggleForms('hide'); ;
				toggleCrudButtons('show');
				alert('Success! Record has been edited.');
			} else {
				alert('Failure! An error has occurred!');
			}
		}
	);
}

function getRole(role) {
	if (role == 1) {
		return 'Admin';
	} else if (role == 2) {
		return 'Regular';
	} else {
		return 'Unknown';
	} 
}

function hasSelected() {
	var selected = $('input:radio[name=index]:checked').val();
	if (selected == undefined) { 
		alert('Select a record first!');
		return false;
	}
	
	return true;
}

function fillEditForm() {
	var selected = $('input:radio[name=index]:checked').val();
	$('#editUsername').val( $('#tableUsers').data('model')[selected].username );
	$('#editFirstName').val( $('#tableUsers').data('model')[selected].firstName );
	$('#editLastName').val( $('#tableUsers').data('model')[selected].lastName );
	$('#editRole').val( $('#tableUsers').data('model')[selected].role );
}

function resetNewForm() {
	$('#newUsername').val('');
	$('#newPassword').val('');
	$('#newFirstName').val('');
	$('#newLastName').val('');
	$('#newRole').val('2');
}

function resetEditForm() {
	$('#editFirstName').val('');
	$('#editLastName').val('');
	$('#editRole').val('2');
}

function toggleForms(id) {
	if (id == 'hide') {
		$('#newForm').hide();
		$('#editForm').hide();
		
	} else if (id == 'new') {
 		resetNewForm();
 		$('#newForm').show();
 		$('#editForm').hide();
 		
	} else if (id == 'edit') {
 		resetEditForm();
 		$('#newForm').hide();
 		$('#editForm').show();
	}
}

function toggleCrudButtons(id) {
	if (id == 'show') {
		$('#newBtn').removeAttr('disabled');
		$('#editBtn').removeAttr('disabled');
		$('#deleteBtn').removeAttr('disabled');
		$('#reloadBtn').removeAttr('disabled');
		
	} else if (id == 'hide'){
		$('#newBtn').attr('disabled', 'disabled');
		$('#editBtn').attr('disabled', 'disabled');
		$('#deleteBtn').attr('disabled', 'disabled');
		$('#reloadBtn').attr('disabled', 'disabled');
	}
}
