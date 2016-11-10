INSERT INTO public.attribute (id, name) VALUES (1, 'border-radius');
INSERT INTO public.attribute (id, name) VALUES (2, 'cursor');

INSERT INTO public.browser (id, name) VALUES (1, 'Chrome');
INSERT INTO public.browser (id, name) VALUES (2, 'IE');

INSERT INTO public.version (id, name) VALUES (1, '49');
INSERT INTO public.version (id, name) VALUES (2, '51');
INSERT INTO public.version (id, name) VALUES (3, '52');
INSERT INTO public.version (id, name) VALUES (4, '8');
INSERT INTO public.version (id, name) VALUES (5, '11');

INSERT INTO public.browser_to_version (browser_id, version_id) VALUES (1, 1);
INSERT INTO public.browser_to_version (browser_id, version_id) VALUES (1, 2);
INSERT INTO public.browser_to_version (browser_id, version_id) VALUES (1, 3);
INSERT INTO public.browser_to_version (browser_id, version_id) VALUES (2, 4);
INSERT INTO public.browser_to_version (browser_id, version_id) VALUES (2, 5);

INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version_id, supported) VALUES (1, 1, 1, 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version_id, supported) VALUES (1, 1, 2, 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version_id, supported) VALUES (1, 1, 3, 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version_id, supported) VALUES (1, 2, 1, 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version_id, supported) VALUES (1, 2, 2, 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version_id, supported) VALUES (1, 2, 3, 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version_id, supported) VALUES (2, 2, 4, 'PARTIAL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version_id, supported) VALUES (2, 1, 4, 'NOT');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version_id, supported) VALUES (2, 1, 5, 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version_id, supported) VALUES (2, 2, 5, 'FULL');