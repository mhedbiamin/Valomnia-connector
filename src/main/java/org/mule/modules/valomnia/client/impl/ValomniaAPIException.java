/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
 */


package org.mule.modules.valomnia.client.impl;

public class ValomniaAPIException extends RuntimeException {

	private static final long serialVersionUID = 7777L;

	public ValomniaAPIException(final String message) {
		super(message);
	}

	public ValomniaAPIException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ValomniaAPIException(final Throwable cause) {
		super(cause);
	}
}