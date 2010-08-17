function setFocus( aForm )
{
	if( aForm.elements[0]!=null) {
		var i;
		var max = aForm.length;
		for( i = 0; i < max; i++ ) {
			if( aForm.elements[ i ].type != "hidden" &&
				!aForm.elements[ i ].disabled &&
				!aForm.elements[ i ].readOnly ) {
				aForm.elements[ i ].focus();
				break;
			}
		}
	}
}

function activateTab(tabName) {
	var tabber = $(".tabberlive").attr("tabber");
	for (i=0; i<tabber.tabs.length; i++) {
		if (tabber.tabs[i].headingText == tabName || tabber.tabs[i].div.id == tabName) {
			tabber.tabShow(i);
			break;
		}
	}
}