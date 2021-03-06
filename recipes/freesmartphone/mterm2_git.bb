require cornucopia.inc

DESCRIPTION = "mterm is a versatile muxer-aware terminal program"
HOMEPAGE = "http://www.freesmartphone.org/index.php/Implementations/fso-term"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
DEPENDS = "dbus dbus-glib readline libfsoframework libfsotransport"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PV = "1.9.0+gitr${SRCPV}"
PE = "1"
PR = "${INC_PR}.0"

S = "${WORKDIR}/git/tools/${PN}"

FILES_${PN} += "${datadir}"
