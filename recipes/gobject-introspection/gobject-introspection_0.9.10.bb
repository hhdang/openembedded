# NOTE: WIP! This recipe does not cross-compile atm., only -native
SECTION = "libs"
DEPENDS = "glib-2.0 libffi"
BBCLASSEXTEND = "native"
DEPENDS_virtclass-native = "glib-2.0-native libffi-native"
LICENSE = "LGPL"

SRC_URI[md5sum] = "e5cd63d6bcc5c105e898e7c33cf42175"
SRC_URI[sha256sum] = "4bf244db75df04499dea704e7734376c0fc5a3a17fb59be2123c8d76111e6fb8"

SRC_URI = "\
  http://ftp.acc.umu.se/pub/GNOME/sources/gobject-introspection/0.9/${BPN}-${PV}.tar.bz2 \
"
S = "${WORKDIR}/${BPN}-${PV}"

inherit autotools

do_configure_prepend() {
	touch -f gtk-doc.make
}

EXTRA_OECONF = "\
  --disable-gtk-doc \
  --disable-gtk-doc-html \
  --disable-gtk-doc-pdf \
  --disable-tests \
"